/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUCYLEONOR
 */
public class Helper {
    
    public static int mensaje(Component ventana, String info, String titulo, int tipo) {
        int retorno = -1;
        switch (tipo) {
            case 1:
                JOptionPane.showMessageDialog(ventana, info, titulo, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(ventana, info, titulo, JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                retorno = JOptionPane.showConfirmDialog(ventana, info, titulo, JOptionPane.YES_NO_OPTION);
                break;
        }
        return retorno;
    }
    
    public static String recibirDatos(Component ventana, String info) {
        String aux;
        aux = JOptionPane.showInputDialog(ventana, info);
        return aux;
    }
    
    public static void habilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(true);
        }
    }
    
    public static void deshabilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);
        }
    }
    
    public static void limpiarTabla(JTable tabla) {
        int nf, nc;
        nf = tabla.getRowCount();
        nc = tabla.getColumnCount();
        
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                
                tabla.setValueAt("", i, j);
                
            }
            
        }
    }
    
    public static void tablaPorDefecto(JTable tabla) {
        DefaultTableModel tm;
        tm = (DefaultTableModel) tabla.getModel();
        tm.setColumnCount(0);
        tm.setRowCount(0);
    }
    
    public static int[][] pasarDatosMatriz(JTable tabla1) {
        int nf, nc;
        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        int m[][] = new int[nf][nc];
        
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int) tabla1.getValueAt(i, j);
            }
        }
        return m;
    }
    
    public static String recorridoHaciaArriba(int m[][], int j) {
        String aux = "";
        int nf = m.length;
        for (int i = (nf - 1); i >= 0; i--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }
    
    public static String recorridoHaciaArriba(int m[][], int j, int in, int fin) {
        String aux = "";
        for (int i = in; i >= fin; i--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }
    
    public static String recorridoHaciaAbajo(int m[][], int j) {
        String aux = "";
        int nf = m.length;
        for (int i = 0; i < nf; i++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }
    
    public static String recorridoHaciaAbajo(int m[][], int j, int in, int fin) {
        String aux = "";
        for (int i = in; i < fin; i++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }
    
    public static String recorridoHaciaIzquierda(int[][] m, int i) {
        String aux = "";
        int nc = m[0].length;
        
        for (int j = (nc - 1); j >= 0; j--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }
    
    public static String recorridoHaciaIzquierda(int[][] m, int i, int in, int fin) {
        String aux = "";
        
        for (int j = in; j >= fin; j--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }
    
    public static String recorridoHaciaDerecha(int[][] m, int i) {
        String aux = "";
        int nc = m[0].length;
        
        for (int j = 0; j < nc; j++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }
    
    public static String recorridoHaciaDerecha(int[][] m, int i, int in, int fin) {
        String aux = "";
        
        for (int j = in; j < fin; j++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }
    
    public static String recorridoDiagonalSecundariaArriba(int m[][]) {
        int nc, nf;
        String aux = "";
        nc = m[0].length;
        nf = m.length;
        for (int i = nf - 1; i >= 0; i--) {
            aux = aux + m[i][nc - 1 - i] + " , ";
        }
        
        aux = aux.substring(aux.length() - 2);
        return aux;
    }
    
    public static String recorridoDiagonalSecundariaArriba(int m[][], int in, int fin) {
        int nc, nf;
        String aux = "";
        nc = m[0].length;
        nf = m.length;
        for (int i = in; i >= fin; i--) {
            aux = aux + m[i][nc - 1 - i] + " , ";
        }
        
        aux = aux.substring(aux.length() - 2);
        return aux;
    }
    
    public static String recorridoUno(JTable tabla1) {
        int m[][] = pasarDatosMatriz(tabla1);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";
        
        for (int i = 0; i < nf; i++) {
            if (i == 0) {
                aux = aux + recorridoHaciaDerecha(m, i);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j == nc - 1) {
                aux = aux + recorridoHaciaAbajo(m, j, 1, nf / 2);
            }
        }
        for (int i = 0; i < nf; i++) {
            if (i == nf / 2) {
                aux = aux + recorridoHaciaIzquierda(m, i);
            }
        }
        
        for (int j = 0; j < nc; j++) {
            if (j == 0) {
                aux = aux + recorridoHaciaAbajo(m, j, (nf / 2) + 1, nf - 1);
            }
        }
        for (int i = 0; i < nf; i++) {
            if (i == nf - 1) {
                aux = aux + recorridoHaciaDerecha(m, i);
            }
        }
        
        aux = aux.substring(0, aux.length() - 2);
        return aux;
    }
    
    public static String recorridoDos(JTable tabla1) {
        int m[][] = pasarDatosMatriz(tabla1);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";
        
        for (int j = 0; j < nc; j++) {
            if (j == 0) {
                aux = aux + recorridoHaciaArriba(m, j);
            }
        }
        for (int i = 0; i < nf; i++) {
            if (i == 0) {
                aux = aux + recorridoHaciaDerecha(m, i, 1, nc / 2);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j == nc / 2) {
                aux = aux + recorridoHaciaAbajo(m, j);
            }
        }
        
        for (int i = 0; i < nf; i++) {
            if (i == nf - 1) {
                aux = aux + recorridoHaciaDerecha(m, i, (nc / 2) + 1, nc - 1);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j == nc - 1) {
                aux = aux + recorridoHaciaArriba(m, j);
            }
        }
        
        aux = aux.substring(0, aux.length() - 2);
        return aux;
    }
    
    public static String recorridoTres(JTable tabla) {
        int m[][] = pasarDatosMatriz(tabla);
        int nc, nf;
        nc = m[0].length;
        nf = m.length;
        String aux = "";
        
        for (int i = 0; i < nf; i++) {
            if (i == (nf / 2) - 1) {
                aux += recorridoHaciaDerecha(m, i, (nc / 2) - 1, nc / 2);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j == nc / 2) {
                aux += recorridoHaciaAbajo(m, j, (nf / 2) - 1, nf / 2);
            }
        }
        for (int i = 0; i < nf; i++) {
            if (i == nf / 2) {
                aux += recorridoHaciaIzquierda(m, i, nc / 2, 1);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j == 1) {
                aux += recorridoHaciaArriba(m, j, (nf / 2) - 1, 1);
            }
        }
        for (int i = 0; i < nf; i++) {
            if (i == 1) {
                aux += recorridoHaciaDerecha(m, i, 2, nc - 1);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j == nc - 2) {
                aux += recorridoHaciaAbajo(m, j, 2, nf - 2);
            }
        }
        for (int i = 0; i < nf; i++) {
            if (i == nf - 2) {
                aux += recorridoHaciaIzquierda(m, i, nc - 2, 1);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j == 0) {
                aux += recorridoHaciaArriba(m, j, nf - 2, 0);
            }
        }
        for (int i = 0; i < nf; i++) {
            if (i == 0) {
                aux += recorridoHaciaDerecha(m, i, 1, nc - 1);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j == nc - 1) {
                aux += recorridoHaciaAbajo(m, j, 0, nf - 1);
            }
        }
        for (int i = 0; i < nf; i++) {
            if (i == nf - 1) {
                aux += recorridoHaciaIzquierda(m, i);
            }
        }
        aux = aux.substring(0, aux.length() - 2);
        return aux;
    }
    
    public static String recorridoCuatro(JTable tabla) {
        int m[][] = pasarDatosMatriz(tabla);
        int nc, nf;
        nc = m[0].length;
        nf = m.length;
        String aux = "";
        
        for (int i = 0; i < nf; i++) {
            if (i == 0) {
                aux += recorridoHaciaDerecha(m, i, 0, nc - 1);
            }
            aux += m[i][nc - 1 - i] + " , ";
            
        }
        
        for (int i = 0; i < nf; i++) {
            if (i == nf - 1) {
                aux += recorridoHaciaDerecha(m, i, 1, nc);
            }
        }
        
        aux = aux.substring(0, aux.length() - 2);
        return aux;
    }
    
    public static String recorridoCinco(JTable tabla) {
        int m[][] = pasarDatosMatriz(tabla);
        int nc, nf;
        nc = m[0].length;
        nf = m.length;
        String aux = "";
        
        for (int j = 0; j < nc; j++) {
            if (j == 0) {
                aux += recorridoHaciaArriba(m, j, nf - 1, 1);
            }
            
        }
        
        for (int i = 0; i < nf / 2; i++) {
            aux += m[i][i] + " , ";
        }
        
        for (int i = nf / 2; i >= 0; i--) {
            aux += m[i][nc - 1 - i] + " , ";
        }
        for (int j = 0; j < nc; j++) {
            if (j == nc - 1) {
                aux += recorridoHaciaAbajo(m, j, 1, nf);
            }
        }
        
        return aux;
        
    }
    
}
