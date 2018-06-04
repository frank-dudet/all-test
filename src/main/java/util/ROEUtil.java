package util;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: frank_du
 * Time : 2018/1/9 上午10:16
 */
public class ROEUtil {

    public static void main(String[] args) {

        Map<String, Double> pingAnmap1 = new HashMap<String, Double>();
        pingAnmap1.put("netProfits", new Double(72368));
        pingAnmap1.put("revenue", new Double(712453));
        pingAnmap1.put("totalAssets", new Double(5576903));
        pingAnmap1.put("ownerEquity", new Double(383449));
        String pinganMsg1 = "平安2016：";
        calculateROE(pingAnmap1, pinganMsg1);

        Map<String, Double> pingAnmap2 = new HashMap<String, Double>();
        pingAnmap2.put("netProfits", new Double(65178));
        pingAnmap2.put("revenue", new Double(619990));
        pingAnmap2.put("totalAssets", new Double(4765159));
        pingAnmap2.put("ownerEquity", new Double(334248));
        String pinganMsg2 = "平安2015：";
        calculateROE(pingAnmap2, pinganMsg2);


        Map<String, Double> pingAnmap3 = new HashMap<String, Double>();
        pingAnmap3.put("netProfits", new Double(47930));
        pingAnmap3.put("revenue", new Double(462882));
        pingAnmap3.put("totalAssets", new Double(4005911));
        pingAnmap3.put("ownerEquity", new Double(289564));
        String pinganMsg3 = "平安2014：";
        calculateROE(pingAnmap2, pinganMsg3);


        Map<String, Double> taibaoMap = new HashMap<String, Double>();
        taibaoMap.put("netProfits", new Double(12057));
        taibaoMap.put("revenue", new Double(267014));
        taibaoMap.put("totalAssets", new Double(1020692));
        taibaoMap.put("ownerEquity", new Double(131764));
        String taibaoMsg1 = "太保2016：";
        calculateROE(taibaoMap, taibaoMsg1);
    }

    public static double calculateROE(Map<String, Double> params, String msg) {

        System.out.println(msg);
        double roe;
        Double netProfits = params.get("netProfits");
        Double revenue = params.get("revenue");
        Double totalAssets = params.get("totalAssets");
        Double ownerEquity = params.get("ownerEquity");

        double netProfitMargin = netProfits/revenue;
        double assetTurnover = revenue/totalAssets;
        double equityMultiplier = totalAssets/ownerEquity;
        roe = netProfits/ownerEquity;

        DecimalFormat df = new DecimalFormat("0.00%");
        String msgOut = String.format("销售净利率：%s, 资产周转率： %s,  权益乘数： %s, ROE： %s",
                df.format(netProfitMargin), df.format(assetTurnover),
                df.format(equityMultiplier), df.format(roe));

        System.out.println(msgOut);
        return roe;

    }
}
