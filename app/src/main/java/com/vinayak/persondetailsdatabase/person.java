package com.vinayak.persondetailsdatabase;
//This is person module
public class person {
    private String fname;
    private String lname;
    private String mno;
    private String email;
    private String city;
    private String address;

    public person (String fname, String lname, String mno, String email, String city, String address){
        this.fname=fname;
        this.lname=lname;
        this.mno=mno;
        this.email=email;
        this.city=city;
        this.address=address;
    }
//    fame get and set
    public String getfname(){
        return fname;
    }

    public void setfname( String fname){
        this.fname= fname;
    }


    public String getlname() {
        return lname;
    }

    public void setlname(String lname) {
        this.lname = lname;
    }


    public String getmno() {
        return mno;
    }

    public void setmno(String mno) {
        this.mno = mno;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getcity() {
        return city;
    }

    public void setcity(String city) {
        this.city = city;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }
}



