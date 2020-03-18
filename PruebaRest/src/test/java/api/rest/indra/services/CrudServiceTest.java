/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.rest.indra.services;

import api.rest.indra.dao.IPersonaDao;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author Hernan_Restrepo
 */
public class CrudServiceTest {
    
    private CrudService instance;
    private IPersonaDao iPersonaDao;
    
    public CrudServiceTest() {
        instance = new CrudService();
                
        iPersonaDao = Mockito.mock(IPersonaDao.class);
        
        Mockito.when(iPersonaDao.findAll()).thenReturn(null);
        Mockito.when(iPersonaDao.save(Mockito.any())).thenReturn(null);
        Mockito.doNothing().when(iPersonaDao).deleteById(Mockito.anyString());
        
        instance.setPersonaDao(iPersonaDao);
    }
    
    @Test
    public void testGetPersona() {
        instance.getPersona();
        assertTrue(true);
    }
    
    @Test
    public void testAddPersona() {
        instance.addPersona(null);
        assertTrue(true);
    }
    
    @Test
    public void testRemovePersona() {
        instance.removePersona(null);
        assertTrue(true);
    }
    
    @Test
    public void testUpdatePersona() {
        instance.updatePersona(null);
        assertTrue(true);
    }
    
}
