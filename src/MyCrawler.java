import Actiuni.IAction;
import Actiuni.derivate.descarcaURL;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyCrawler {
    private static MyCrawler single_instance = null;

    private String configFile;//fisierul de configurare utilizat
    private ArrayList<IAction> actions;

    private MyCrawler()
    {}


    public static MyCrawler getInstance()
    {
        if (single_instance == null)
            single_instance = new MyCrawler();
        return single_instance;
    }

    public void init()
    {
        actions=new ArrayList<IAction>();
        System.out.println("Facem actiunile specifice initiereii primind argumentele programului");
        IAction a=new descarcaURL("a","b");
        actions.add(a);
    }

    public int run()
    {
        //iteratie prin toate actiunile si urmare a suprascrierii metodelor _do
        for(IAction act:actions)
            act._print();
        return 1;
    }
}
