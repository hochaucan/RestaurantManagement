/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.util.List;

/**
 *
 * @author Nick
 */
public interface ICrudGeneral<T> {

    List<T> getList();

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    <T> T getEntitytById(int entityId);
}
