/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPack;


import java.util.Calendar;
import java.util.Date;


public class Dates
{
    Date date;
    
    private final int rentDays;
    
    public Dates(int rentDays)
    {
        this.rentDays = rentDays;
    }
    
    public Date getRentDate()
    {
        date = new Date();
        return date;
    }
    
    public Date getDevDate()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, rentDays);
        date = calendar.getTime();
        return date;
    }
    
}
