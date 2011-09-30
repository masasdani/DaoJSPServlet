/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.dao.impl;

import com.masasdani.dao.interf.DonaturDao;
import com.masasdani.db.DatabaseUtil;
import com.masasdani.entity.Donatur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author badak
 */
public class DonaturDaoImpl implements DonaturDao {

    @Override
    public void save(Donatur donatur) {
        try {
            PreparedStatement ps=DatabaseUtil.getConnection().prepareStatement("insert into donatur(nama, alamat) values(?,?)");
            ps.setString(1, donatur.getNama());
            ps.setString(2, donatur.getAlamat());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DonaturDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Donatur> getAll() {
        List<Donatur> list = new ArrayList<Donatur>();
        try {
            Statement s=DatabaseUtil.getConnection().createStatement();
            ResultSet rs=s.executeQuery("select * from donatur");
            while(rs.next()){
                Donatur d=new Donatur();
                d.setId(rs.getInt(1));
                d.setNama(rs.getString(2));
                d.setAlamat(rs.getString(3));
                list.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonaturDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void update(Donatur d) {
        try {
            PreparedStatement ps=DatabaseUtil.getConnection().prepareStatement("update donatur set nama=?, alamat=? where id=?");
            ps.setString(1, d.getNama());
            ps.setString(2, d.getAlamat());
            ps.setInt(3, d.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DonaturDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Donatur d) {
        try {
            PreparedStatement ps=DatabaseUtil.getConnection().prepareStatement("delete from donatur where id=?");
            ps.setInt(1, d.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DonaturDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Donatur getDonatur(int id) {
        Donatur d=new Donatur();
        try {
            PreparedStatement ps=DatabaseUtil.getConnection().prepareStatement("select * from donatur where id=?");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                d.setId(id);
                d.setNama(rs.getString(2));
                d.setAlamat(rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonaturDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
}
