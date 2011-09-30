/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.dao.factory;

import com.masasdani.dao.impl.DonaturDaoImpl;
import com.masasdani.dao.interf.DonaturDao;

/**
 *
 * @author badak
 */
public class DaoUtil {
    private static DonaturDao donaturDao;

    public static DonaturDao getDonaturDao() {
        if(donaturDao==null){
            donaturDao=new DonaturDaoImpl();
        }
        return donaturDao;
    }
}
