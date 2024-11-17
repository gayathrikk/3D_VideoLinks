package com.gayu.Gayathri;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Annotation_TileDeatils {

    private static final String HOST = "apollo2.humanbrain.in";
    private static final int PORT = 22;
    private static final String USER = "hbp";
    private static final String PASSWORD = "Health#123";
    private static final Map<String, String[]> BIOSAMPLE_MAPPING = new HashMap<>();

    static {
        BIOSAMPLE_MAPPING.put("91", new String[]{"91", "46", "310", "512", "512"});
        // Add other mappings as needed
    }

    @Parameters({"biosampleId", "sectionNo"})
    @Test
    public void testSSHConnection(@Optional String biosampleId, @Optional String sectionNo) {
        if (biosampleId == null || sectionNo == null) {
            Scanner scanner = new Scanner(System.in);

            if (biosampleId == null) {
                System.out.print("Enter biosample ID: ");
                biosampleId = scanner.nextLine();
            }

            if (sectionNo == null) {
                System.out.print("Enter section number: ");
                sectionNo = scanner.nextLine();
            }
        }

        System.out.println("Biosample ID: " + biosampleId);
        System.out.println("Section No: " + sectionNo);

        // Retrieve path components based on biosample ID
        String[] pathComponents = BIOSAMPLE_MAPPING.get(biosampleId);
        if (pathComponents == null) {
            System.out.println("Invalid biosample ID");
            return;
        }

        // Construct the directory path
        String dirPath = String.format("/store/repos1/iitlab/humanbrain/analytics/%s/appData/cellDetection/%s/NISSL/%s/%s/%s/",
                pathComponents[0], pathComponents[1], pathComponents[2], pathComponents[3], pathComponents[4]);

        String command = "ls " + dirPath;

        executeSSHCommand(command, sectionNo);
    }

    private void executeSSHCommand(String command, String sectionNo) {
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

            int pngCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.endsWith(sectionNo + ".png")) {
                    pngCount++;
                }
            }

            // Print the total PNG file count
            System.out.println("Total PNG Count: " + pngCount);

            channelExec.disconnect();
            session.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
