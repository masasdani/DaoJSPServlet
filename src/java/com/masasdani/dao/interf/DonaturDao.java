/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.dao.interf;

import com.masasdani.entity.Donatur;
import java.util.List;

/**
 *
 * @author badak
 */
public interface DonaturDao {
    public void save(Donatur donatur);
    public void update(Donatur d);
    public void delete(Donatur d);
    public List<Donatur> getAll();
    public Donatur getDonatur(int id);
}
