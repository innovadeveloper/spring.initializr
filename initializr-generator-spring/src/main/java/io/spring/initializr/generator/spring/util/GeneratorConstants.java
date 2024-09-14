package io.spring.initializr.generator.spring.util;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GeneratorConstants {

    private static String DOCUMENTATION_DIR = "documentation";
    private static String DEVOPS_DIR = "devops";
    private static String DOCKERFILE_TEMPLATE = "dockerfile-template";
    private static String JENKINSFILEDEV_TEMPLATE = "JenkinsfileDev";
    private static String JENKINSFILEPROD_TEMPLATE = "JenkinsfileProd";
    private static String DEVOPSDEV_TEMPLATE = "devops-dev.yaml";
    private static String DEVOPSPROD_TEMPLATE = "devops-prod.yaml";

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
}
