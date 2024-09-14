package io.spring.initializr.generator.spring.util;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GeneratorConstants {

    private static String DOCUMENTATION_DIR = "documentation";
    private static String LOGBACK_DIR = "logback";
    private static String DEVOPS_DIR = "devops";
    private static String DOCKERFILE_TEMPLATE = "dockerfile-template";
    private static String JENKINSFILEDEV_TEMPLATE = "JenkinsfileDev";
    private static String JENKINSFILEPROD_TEMPLATE = "JenkinsfileProd";
    private static String DEVOPSDEV_TEMPLATE = "devops-dev.yaml";
    private static String DEVOPSPROD_TEMPLATE = "devops-prod.yaml";
    private static String CONSOLE_LOGBACK_TEMPLATE = "console-logback.xml";
    private static String FILE_LOGBACK_TEMPLATE = "file-logback.xml";
    private static String MAIN_FILE_LOGBACK_TEMPLATE = "logback.xml";

    // documentation/dockerfile-template.mustache
    public static Path getDockerfileTemplate(){
        return Paths.get(DEVOPS_DIR).resolve(DOCKERFILE_TEMPLATE);
    }
    public static Path getJenkinsfileDevTemplate(){
        return Paths.get(DEVOPS_DIR).resolve(JENKINSFILEDEV_TEMPLATE);
    }
    public static Path getJenkinsfileProdTemplate(){
        return Paths.get(DEVOPS_DIR).resolve(JENKINSFILEPROD_TEMPLATE);
    }
    public static Path getDevOpsDevTemplate(){
        return Paths.get(DEVOPS_DIR).resolve(DEVOPSDEV_TEMPLATE);
    }
    public static Path getDevOpsProdTemplate(){
        return Paths.get(DEVOPS_DIR).resolve(DEVOPSPROD_TEMPLATE);
    }
    public static Path getConsoleLogbackTemplate(){
        return Paths.get(LOGBACK_DIR).resolve(LOGBACK_DIR).resolve(CONSOLE_LOGBACK_TEMPLATE);
    }
    public static Path getFileLogbackTemplate(){
        return Paths.get(LOGBACK_DIR).resolve(LOGBACK_DIR).resolve(FILE_LOGBACK_TEMPLATE);
    }
    public static Path getMainFileLogbackTemplate(){
        return Paths.get(LOGBACK_DIR).resolve(MAIN_FILE_LOGBACK_TEMPLATE);
    }
}
