package org.xwiki.android.test.fixture.setup.env;

/**
 * Environment variables for tests.
 * How to setup external text setup.
 */

public class TestEnv {

    public static final String DEFAULT_EXECUTION_DIRECTORY="D:\\Xwiki-server"; //machine dependant. If prop not set in pom specify here. ex: for IDE builds
    public static final int SERVER_INDEX;
    public static final String HOST = "localhost";
    public static final int PORT = 8080; //actual port is port+server_index
    public static final String SCHEME="http://";
    public static final String SERVER_URL;  //SERVER NAME set in static block.
    public static final String USERNAME = "Admin";
    public static final String PASSWORD = "admin";

    //external test fixture.

    public static final String WIKI_NAME = "xwiki";

    public static final String SPACE_NAME = "Blog";

    public static final String PAGE_NAME = "test2";

    public static final String PAGE_VERSION = "1.1";

    public static final String COMMENT_ID = "0";
    public static final String COMMENT_TEXT = "hi";
    public static final String COMMENT_REPLY_ID = "1";
    public static final int COMMENT_REPLY_REPLY_TO = 0;
    public static final String COMMENT_PAGE_HISTORY_VERSION="5.1";
    public static final String COMMENT_REPLY_TEXT = "huy";


    public static final String LANGUAGE = "fr";
    public static final String TRANSLATION_VERSION="2.1";

    public static final String CLASS_NAME = "Blog.BlogPostClass";
    public static final String OBJECT_NUMBER = "0";
    public static final String OBJECT_PROPERTY_NAME = "content";
    public static final String OBJECT_PROPERTY_VALUE = "test blog content";

    public static final String SEARCH_KEWORD = "test";

    public static final String TAG_WORD = "testTag";

    public static final String ATTACHMENT_NAME = "a.png";
    public static final String ATTACHMENT_DEL_NAME = "del.png";
    public static final String ATTACHMENT_PATH = "./";
    public static final String ATTACHMENT_VERSION = "1.1";
    public static final String ATTACHMENT_PAGE_HISTORY_VERSION = "9.1";

    static {
        SERVER_INDEX = new Integer(System.getProperty("xwikiExecutionIndex", "0"));
        SERVER_URL = HOST + ":" + (PORT + SERVER_INDEX);
        if(System.getProperty("xwikiExecutionDirectory")==null){
            System.out.println("ERROR : xwikiExecutionDirectory not set in pom. ");
            if(DEFAULT_EXECUTION_DIRECTORY==null){
                throw new RuntimeException("If IDE build, set a defalut xwiki execution directory for you local machine. see TestConstants.DEFAULT_EXECUTION_DIRECTORY") ;
            }
            if(SERVER_INDEX>0){
                System.setProperty("xwikiExecutionDirectory", DEFAULT_EXECUTION_DIRECTORY+"-"+SERVER_INDEX);//set it up to default val above, if not set by pom.else rewrite.
            }else{
                System.setProperty("xwikiExecutionDirectory", DEFAULT_EXECUTION_DIRECTORY);//set it up to default val above, if not set by pom.else rewrite.
            }
        }
        System.out.println("xwiki execution dir:"+ System.getProperty("xwikiExecutionDirectory") +" index: "+SERVER_INDEX + " server Url: "+SERVER_URL);
    }

}
