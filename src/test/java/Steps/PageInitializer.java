package Steps;

import Pages.NestedFrames;
import Pages.Widgets;
import Utils.CommonMethods;

public class PageInitializer {

    public static Widgets widgets;

    public static NestedFrames nestedFrames;






    public static void initializePageObjects(){

    widgets = new Widgets();
    nestedFrames = new NestedFrames();



    }
}
