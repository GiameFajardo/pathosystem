/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.modelo;

/**
 *
 * @author Chu
 */
public class PersistenceUnits {
    
    private static String localPersistedUnit = "com.mycompany_appPatologia_jar_1.0-SNAPSHOTPU";

    /**
     * @return the localContext
     */
    public static String getLocalContext() {
        return localPersistedUnit;
    }
}
