package com.JCalculator;

import java.io.IOException;

public class CalculateResult extends ExtendsMathFormul {
    static int singTest = 0;
    static int singTestR = 0;

    public void result(String resultation) throws IOException {
         HelpOperations helper=new HelpOperations();
        helper.listCreator(resultation);
        multiAndDivision();
        additionAndSubtraction();




    }


}