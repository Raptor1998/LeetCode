package com.enternal.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solve {

    public static void main(String[] args) {
        Map<String, List<Company>> map = new HashMap<>();
        ArrayList<Company> companiesA = new ArrayList<>();
        companiesA.add(new Company("B1",0.3));
        companiesA.add(new Company("B2",0.7));
        map.put("A",companiesA);

        ArrayList<Company> companiesB1 = new ArrayList<>();
        companiesB1.add(new Company("C1",0.2));
        companiesB1.add(new Company("C2",0.8));
        map.put("B1",companiesB1);

        ArrayList<Company> companiesB2 = new ArrayList<>();
        companiesB1.add(new Company("C1",1.0));
        map.put("B2",companiesB2);
        System.out.println(solve(map,"A",0.0));
    }

    public static double solve(Map<String, List<Company>> map,String companyName,double ans){
        if (!map.containsKey(companyName)){
            return ans;
        }else{
            List<Company> companies = map.get(companyName);
            for (Company company : companies) {
                ans += (company.getP() * solve(map,company.getCompanyName(),ans));
            }
            return ans;
        }
    }
}

class Company{
    private String CompanyName;
    private double p;

    public Company(String companyName, double p) {
        CompanyName = companyName;
        this.p = p;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }
}
