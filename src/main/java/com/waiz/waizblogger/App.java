package com.waiz.waizblogger;

public class App
{
    public static void main( String[] args )
    {
        for (String arg : args) {
            switch(arg) {
                case "-v":
                    printVersion();
                    break;
                case "-h":
                    printHelp();
                    break;
                case "new":
                    ProjectManager.newProject("Project");
                    break;               
            }
        }
    }

    public static void printHelp() {
        String help = "WaizBlogger\n"
            + "new\t create new Project\n"
            + "-h\t shows this menu\n"
            + "-v\t show version\n";

        System.out.println(help);
    }

    public static void printVersion() {
        String version = App.class.getPackage().getImplementationVersion();
        String title = App.class.getPackage().getImplementationTitle();
        System.out.println(title+" v"+version);
    }
}
