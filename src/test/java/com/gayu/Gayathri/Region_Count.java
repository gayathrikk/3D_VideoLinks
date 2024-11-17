package com.gayu.Gayathri;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Region_Count {

    private static final String HOST = "apollo2.humanbrain.in";
    private static final int PORT = 22;
    private static final String USER = "hbp";
    private static final String PASSWORD = "Health#123";

    private static final Map<String, String[]> BIOSAMPLE_MAPPING = new HashMap<>();

    static {
        BIOSAMPLE_MAPPING.put("213", new String[]{"94", "274"});
        BIOSAMPLE_MAPPING.put("244", new String[]{"116", "324"});
        BIOSAMPLE_MAPPING.put("142", new String[]{"65", "182"});
        BIOSAMPLE_MAPPING.put("222", new String[]{"100", "306"});
        BIOSAMPLE_MAPPING.put("141", new String[]{"62", "148"});
    }

    @Parameters({"biosampleId", "sectionNumbers"})
    @Test
    public void testSSHConnection(@Optional String biosampleId, @Optional String sectionNumbers) {
        if (biosampleId == null || sectionNumbers == null) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter biosample ID: ");
            biosampleId = scanner.nextLine();

            System.out.print("Enter section numbers (comma-separated): ");
            sectionNumbers = scanner.nextLine();
        }

        System.out.println("Biosample ID: " + biosampleId);
        System.out.println("Section Numbers: " + sectionNumbers);

        // Retrieve series set ID and series type based on biosample ID
        String[] seriesInfo = BIOSAMPLE_MAPPING.get(biosampleId);
        if (seriesInfo == null) {
            System.out.println("Invalid biosample ID");
            return;
        }
        String seriesSetId = seriesInfo[0];
        String seriesType = seriesInfo[1];

        // Split section numbers and process each section
        String[] sections = sectionNumbers.split(",");
        Set<String> allUniqueRegions = new HashSet<>();

        for (String sectionNo : sections) {
            sectionNo = sectionNo.trim(); // Remove any extra spaces
            String filePath = String.format("/store/repos1/iitlab/humanbrain/analytics/%s/appData/atlasEditor/189/NISL/%s/%s-NISL-%s-FlatTree::IIT:V1:SS-%s:%s:%s:%s.json",
                    biosampleId, sectionNo, biosampleId, sectionNo, seriesSetId, seriesType, sectionNo, sectionNo);

            String command = "cat " + filePath;
            Set<String> uniqueRegionsForSection = executeSSHCommand(command);
            allUniqueRegions.addAll(uniqueRegionsForSection);
        }

        // Print the unique region names and total count
        System.out.println("Unique Regions:");
        for (String region : allUniqueRegions) {
            System.out.println("Region Name: " + region);
        }

        System.out.println("Total Unique Region Count: " + allUniqueRegions.size());
    }

    private Set<String> executeSSHCommand(String command) {
        Set<String> uniqueRegions = new HashSet<>();
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(USER, HOST, PORT);
            session.setPassword(PASSWORD);

            // Avoid asking for key confirmation
            Properties prop = new Properties();
            prop.put("StrictHostKeyChecking", "no");
            session.setConfig(prop);
            session.connect();

            // SSH Channel
            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(command);

            // Capture the command output
            BufferedReader reader = new BufferedReader(new InputStreamReader(channelExec.getInputStream()));
            channelExec.connect();

            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Parse the JSON output
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(output.toString());

            for (JsonNode feature : rootNode.path("features")) {
                String name = feature.path("properties").path("data").path("name").asText();
                uniqueRegions.add(name);
            }

            channelExec.disconnect();
            session.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return uniqueRegions;
    }
}
