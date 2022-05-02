
package Controlador;

import java.awt.Component;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

public class Funciones
{

    public Funciones()
    {
    }

    public void EstadoBoton(KeyEvent evt, JTextField Actual, JButton Guardar, JButton Modificar, int Activo)
    {
        if(!Actual.getText().equals(""))
        {
            if(Activo == 1)
            {
                Guardar.setEnabled(false);
                Modificar.setEnabled(true);
            }
        } else
        {
            Modificar.setEnabled(false);
        }
    }

    public static void EstadoBotonUltimo(KeyEvent evt, JTextField Actual, JButton Guardar, JButton Modificar, int Activo)
    {
        if(!Actual.getText().equals(""))
        {
            if(Activo == 0)
            {
                Guardar.setEnabled(true);
                Modificar.setEnabled(false);
            }
            if(Activo == 1)
            {
                Guardar.setEnabled(false);
                Modificar.setEnabled(true);
            }
        } else
        {
            Guardar.setEnabled(false);
            Modificar.setEnabled(false);
        }
    }

    public static void EstadoBotonUltimo(KeyEvent evt, JTextArea Actual, JButton Guardar, JButton Modificar, int Activo)
    {
        if(!Actual.getText().equals(""))
        {
            if(Activo == 0)
            {
                Guardar.setEnabled(true);
                Modificar.setEnabled(false);
            }
            if(Activo == 1)
            {
                Guardar.setEnabled(false);
                Modificar.setEnabled(true);
            }
        } else
        {
            Guardar.setEnabled(false);
            Modificar.setEnabled(false);
        }
    }

    public void EstadoBotonModificar(KeyEvent evt, JTextField Actual, JButton Modificar, int Activo)
    {
        if(!Actual.getText().equals(""))
        {
            if(Activo == 0)
                Modificar.setEnabled(false);
            if(Activo == 1)
                Modificar.setEnabled(true);
        } else
        {
            Modificar.setEnabled(false);
        }
    }

    public void EstadoBotonDelNoRequerido(KeyEvent evt, JTextField Actual, JButton Guardar, JButton Modificar, int Activo)
    {
        if(Actual.getText().equals(""))
        {
            if(Activo == 0)
            {
                Guardar.setEnabled(true);
                Modificar.setEnabled(false);
            }
            if(Activo == 1)
            {
                Guardar.setEnabled(false);
                Modificar.setEnabled(true);
            }
        }
    }

    public void EstadoBotonModificarDelNoRequerido(KeyEvent evt, JButton Modificar, int Activo)
    {
        if(Activo == 0)
            Modificar.setEnabled(false);
        if(Activo == 1)
            Modificar.setEnabled(true);
    }

    public void EstadoBotonPrimariaEnter(KeyEvent evt, JTextField Primaria, JButton Guardar, JButton Modificar)
    {
        if(Primaria.isEnabled())
        {
            Guardar.setEnabled(true);
            Modificar.setEnabled(false);
        } else
        {
            Guardar.setEnabled(false);
            Modificar.setEnabled(true);
        }
    }

    public void EstadoBotonPrimariaClick(MouseEvent evt, JTextField Primaria, JButton Guardar, JButton Modificar)
    {
        if(Primaria.isEnabled())
        {
            Guardar.setEnabled(true);
            Modificar.setEnabled(false);
        } else
        {
            Guardar.setEnabled(false);
            Modificar.setEnabled(true);
        }
    }

    public void PasarTextAText(KeyEvent evt, JTextField Actual, JTextField Siguiente, String Mensaje)
    {
        if(evt.getSource().equals(Actual) && evt.getKeyCode() == 10)
            if(Actual.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, Mensaje);
                Actual.grabFocus();
            } else
            {
                Siguiente.setEnabled(true);
                Siguiente.grabFocus();
            }
    }

    public void PasarFormatoTextAFormatoText(KeyEvent evt, JFormattedTextField Actual, JFormattedTextField Siguiente, String Mensaje)
    {
        if(evt.getSource().equals(Actual) && evt.getKeyCode() == 10)
            if(Actual.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, Mensaje);
                Actual.grabFocus();
            } else
            {
                Siguiente.setEnabled(true);
                Siguiente.grabFocus();
            }
    }

    public void PasarTextATextNoRequerido(KeyEvent evt, JTextField Actual, JComponent Siguiente)
    {
        if(evt.getSource().equals(Actual) && evt.getKeyCode() == 10)
        {
            Siguiente.setEnabled(true);
            Siguiente.grabFocus();
        }
    }

    public static void PasarTextABoton(KeyEvent evt, JTextField Actual, JButton Guardar, JButton Modificar, JButton Eliminar, String Mensaje)
    {
        if(evt.getSource().equals(Actual) && evt.getKeyCode() == 10)
            if(Actual.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, Mensaje);
                Actual.grabFocus();
            } else
            if(Guardar.isEnabled())
                Guardar.grabFocus();
            else
            if(Modificar.isEnabled())
                Modificar.grabFocus();
            else
                Eliminar.grabFocus();
    }

    public void PasarTextABoton(KeyEvent evt, JTextArea Actual, JButton Guardar, JButton Modificar, JButton Eliminar, String Mensaje)
    {
        if(evt.getSource().equals(Actual) && evt.getKeyCode() == 10)
            if(Actual.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, Mensaje);
                Actual.grabFocus();
            } else
            if(Guardar.isEnabled())
                Guardar.grabFocus();
            else
            if(Modificar.isEnabled())
                Modificar.grabFocus();
            else
                Eliminar.grabFocus();
    }

    public void PasarCheckABoton(ActionEvent evt, JCheckBox Actual, JButton Guardar, JButton Modificar, int Activo)
    {
        if(Actual.isSelected())
        {
            if(Activo == 0)
            {
                Guardar.setEnabled(true);
                Modificar.setEnabled(false);
            }
            if(Activo == 1)
            {
                Guardar.setEnabled(false);
                Modificar.setEnabled(true);
            }
        } else
        {
            Guardar.setEnabled(false);
            Modificar.setEnabled(false);
        }
    }

    public void PasarCheck(ActionEvent evt, JTextField Actual, JButton Guardar, JButton Modificar, int Activo)
    {
        if(!Actual.getText().equals(""))
        {
            if(Activo == 0)
            {
                Guardar.setEnabled(true);
                Modificar.setEnabled(false);
            }
            if(Activo == 1)
            {
                Guardar.setEnabled(false);
                Modificar.setEnabled(true);
            }
        } else
        {
            Guardar.setEnabled(false);
            Modificar.setEnabled(false);
        }
    }

    public void PasarTextACombo(KeyEvent evt, JTextField Actual, JComboBox Siguiente, String Mensaje)
    {
        if(evt.getSource().equals(Actual) && evt.getKeyCode() == 10)
            if(Actual.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, Mensaje);
                Actual.grabFocus();
            } else
            {
                Siguiente.setEnabled(true);
                Siguiente.grabFocus();
            }
    }

    public void PasarFormatoTextACombo(KeyEvent evt, JFormattedTextField Actual, JComboBox Siguiente, String Mensaje)
    {
        if(evt.getSource().equals(Actual) && evt.getKeyCode() == 10)
            if(Actual.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, Mensaje);
                Actual.grabFocus();
            } else
            {
                Siguiente.setEnabled(true);
                Siguiente.grabFocus();
            }
    }

    public void PasarTextAComboNoRequerido(KeyEvent evt, JTextField Actual, JComboBox Siguiente)
    {
        if(evt.getSource().equals(Actual) && evt.getKeyCode() == 10)
        {
            Siguiente.setEnabled(true);
            Siguiente.grabFocus();
        }
    }

    public void ComboAnteriorVacio(FocusEvent evt, JComboBox Actual)
    {
        if(Actual.getSelectedItem().equals(""))
            Actual.grabFocus();
    }

    public void TextAnteriorVacio(FocusEvent evt, JTextField Actual)
    {
        if(Actual.getText().equals(""))
            Actual.grabFocus();
    }

    public void PasarComboAText(KeyEvent evt, JComboBox Actual, JTextField Siguiente, JButton Guardar, JButton Modificar, String Mensaje, int Activo)
    {
        if(evt.getSource().equals(Actual) && evt.getKeyCode() == 10)
            if(Actual.getSelectedItem().equals(" "))
            {
                JOptionPane.showMessageDialog(null, Mensaje);
                Actual.grabFocus();
            } else
            {
                Siguiente.setEnabled(true);
                Siguiente.grabFocus();
            }
        if(!Actual.getSelectedItem().equals(" "))
        {
            if(Activo == 0)
            {
                Guardar.setEnabled(true);
                Modificar.setEnabled(false);
            }
            if(Activo == 1)
            {
                Guardar.setEnabled(false);
                Modificar.setEnabled(true);
            }
        } else
        {
            Guardar.setEnabled(false);
            Modificar.setEnabled(false);
        }
    }

    public void PasarComboACombo(KeyEvent evt, JComboBox Actual, JComboBox Siguiente, JButton Guardar, JButton Modificar, String Mensaje, int Activo)
    {
        if(evt.getSource().equals(Actual) && evt.getKeyCode() == 10)
            if(Actual.getSelectedItem().equals(" "))
            {
                JOptionPane.showMessageDialog(null, Mensaje);
                Actual.grabFocus();
            } else
            {
                Siguiente.setEnabled(true);
                Siguiente.grabFocus();
            }
        if(!Actual.getSelectedItem().equals(" "))
        {
            if(Activo == 0)
            {
                Guardar.setEnabled(true);
                Modificar.setEnabled(false);
            }
            if(Activo == 1)
            {
                Guardar.setEnabled(false);
                Modificar.setEnabled(true);
            }
        } else
        {
            Guardar.setEnabled(false);
            Modificar.setEnabled(false);
        }
    }

    public void IconoBoton(JButton boton, String Ruta)
    {
        boton.setIcon(new ImageIcon(getClass().getResource(Ruta)));
        boton.repaint();
    }

    public static boolean Botones(JPanel jPanel, boolean Estado)
    {
        Component componentes[] = new Component[jPanel.getComponentCount()];
        componentes = jPanel.getComponents();
        boolean r = false;
        for(int i = 0; i < jPanel.getComponentCount(); i++)
            if(componentes[i].getClass().getName().equals("javax.swing.JButton"))
            {
                JButton botones = (JButton)componentes[i];
                botones.setEnabled(Estado);
                r = true;
            }

        return r;
    }

    public static void LimpiarText(JPanel jPanel)
    {
        Component componentes[] = new Component[jPanel.getComponentCount()];
        componentes = jPanel.getComponents();
        Component acomponent[] = componentes;
        int i = acomponent.length;
        for(int j = 0; j < i; j++)
        {
            Component componente = acomponent[j];
            if(componente.getClass().getName().equals("javax.swing.JTextField"))
            {
                JTextField caja = (JTextField)componente;
                caja.setText("");
            }
        }

    }

    public boolean LimpiarFormatoText(JPanel jPanel)
    {
        Component componentes[] = new Component[jPanel.getComponentCount()];
        componentes = jPanel.getComponents();
        boolean r = false;
        for(int i = 0; i < jPanel.getComponentCount(); i++)
            if(componentes[i].getClass().getName().equals("javax.swing.JFormattedTextField"))
            {
                JFormattedTextField caja = (JFormattedTextField)componentes[i];
                caja.setText("");
                r = true;
            }

        return r;
    }

    public boolean LimpiarArea(JPanel jPanel)
    {
        Component componentes[] = new Component[jPanel.getComponentCount()];
        componentes = jPanel.getComponents();
        boolean r = false;
        for(int i = 0; i < jPanel.getComponentCount(); i++)
            if(componentes[i].getClass().getName().equals("javax.swing.JTextArea"))
            {
                JTextArea caja = (JTextArea)componentes[i];
                caja.setText("");
                r = true;
            }

        return r;
    }

    public boolean LimpiarCheck(JPanel jPanel)
    {
        Component componentes[] = new Component[jPanel.getComponentCount()];
        componentes = jPanel.getComponents();
        boolean r = false;
        for(int i = 0; i < jPanel.getComponentCount(); i++)
            if(componentes[i].getClass().getName().equals("javax.swing.JCheckBox"))
            {
                JCheckBox caja = (JCheckBox)componentes[i];
                caja.setSelected(false);
                r = true;
            }

        return r;
    }

    public void EstadoCombo(JPanel jPanel, boolean Estado)
    {
        Component componentes[] = new Component[jPanel.getComponentCount()];
        componentes = jPanel.getComponents();
        for(int i = 0; i < jPanel.getComponentCount(); i++)
            if(componentes[i].getClass().getName().equals("javax.swing.JComboBox"))
            {
                JComboBox caja = (JComboBox)componentes[i];
                caja.setEnabled(Estado);
            }

    }

    public boolean EstadoCheck(JPanel jPanel, boolean Estado)
    {
        Component componentes[] = new Component[jPanel.getComponentCount()];
        componentes = jPanel.getComponents();
        boolean r = false;
        for(int i = 0; i < jPanel.getComponentCount(); i++)
            if(componentes[i].getClass().getName().equals("javax.swing.JCheckBox"))
            {
                JCheckBox caja = (JCheckBox)componentes[i];
                caja.setEnabled(Estado);
                r = true;
            }

        return r;
    }

    public boolean EstadoRadio(JPanel jPanel, boolean Estado)
    {
        Component componentes[] = new Component[jPanel.getComponentCount()];
        componentes = jPanel.getComponents();
        boolean r = false;
        for(int i = 0; i < jPanel.getComponentCount(); i++)
            if(componentes[i].getClass().getName().equals("javax.swing.JRadioButton"))
            {
                JRadioButton caja = (JRadioButton)componentes[i];
                caja.setEnabled(Estado);
                r = true;
            }

        return r;
    }

    public boolean LimpiarCombos(JPanel jPanel)
    {
        Component componentes[] = new Component[jPanel.getComponentCount()];
        componentes = jPanel.getComponents();
        boolean r = false;
        for(int i = 0; i < jPanel.getComponentCount(); i++)
            if(componentes[i].getClass().getName().equals("javax.swing.JComboBox"))
            {
                JComboBox caja = (JComboBox)componentes[i];
                caja.setSelectedItem("");
                r = true;
            }

        return r;
    }

    public static void Numerico(KeyEvent evt)
    {
        char caracter = evt.getKeyChar();
        if(!Character.isDigit(caracter) && caracter != '\b')
            evt.consume();
    }

    public void CantidadDigitos(KeyEvent evt, JTextField Actual, int Cantidad)
    {
        char caracter = evt.getKeyChar();
        if(Actual.getText().length() >= Cantidad && caracter != '\b')
            evt.consume();
    }

    public void CantidadDigitos(KeyEvent evt, JTextArea Actual, int Cantidad)
    {
        char caracter = evt.getKeyChar();
        if(Actual.getText().length() >= Cantidad && caracter != '\b')
            evt.consume();
    }

    public void CantidadDigitos(KeyEvent evt, JFormattedTextField Actual, int Cantidad)
    {
        char caracter = evt.getKeyChar();
        if(Actual.getText().length() >= Cantidad && caracter != '\b')
            evt.consume();
    }

    public void CuentaBancaria(KeyEvent evt)
    {
        char caracter = evt.getKeyChar();
        if(!Character.isDigit(caracter) && caracter != '-' && caracter != '\b')
            evt.consume();
    }

    public void Decimales(KeyEvent evt)
    {
        char caracter = evt.getKeyChar();
        if(!Character.isDigit(caracter) && caracter != '.' && caracter != '\b')
            evt.consume();
    }

    public void Nit(KeyEvent evt)
    {
        char caracter = evt.getKeyChar();
        if(!Character.isDigit(caracter) && caracter != '.' && caracter != '-' && caracter != '\b')
            evt.consume();
    }

    public void Email(KeyEvent evt)
    {
        char caracter = evt.getKeyChar();
        if(!Character.isDigit(caracter) && caracter != '_' && caracter != '@' && caracter != '\b')
            evt.consume();
    }

    public void Telefonos(KeyEvent evt)
    {
        char caracter = evt.getKeyChar();
        if(!Character.isDigit(caracter) && caracter != '\b' && caracter != '-')
            evt.consume();
    }

    public static void Letras(KeyEvent evt)
    {
        char caracter = evt.getKeyChar();
        if(!Character.isLetter(caracter) && caracter != '\b' && caracter != '\177')
            evt.consume();
    }

    public void Digitos(int numeros, String Concatenar, JTextField recibe)
    {
        int numero = numeros;
        String num;
        if(numero < 10)
            num = (new StringBuilder()).append("0").append(numero).toString();
        else
            num = (new StringBuilder()).append("").append(numero).toString();
        recibe.setText((new StringBuilder()).append(Concatenar).append(num).toString());
    }

    public void DigitosGrupo(int numeros, String Concatenar, JTextField recibe)
    {
        int numero = numeros;
        String num;
        if(numero < 10)
            num = (new StringBuilder()).append("0").append(numero).toString();
        else
            num = (new StringBuilder()).append("").append(numero).toString();
        if(Concatenar.length() < 2)
            Concatenar = (new StringBuilder()).append("0").append(Concatenar).toString();
        recibe.setText((new StringBuilder()).append(Concatenar).append(num).toString());
    }

    public void DigitosCompetencias(int numeros, String Concatenar, JTextField recibe)
    {
        int numero = numeros;
        String num;
        if(numero > 99)
            num = (new StringBuilder()).append("").append(numero).toString();
        else
        if(numero > 9)
            num = (new StringBuilder()).append("0").append(numero).toString();
        else
            num = (new StringBuilder()).append("00").append(numero).toString();
        recibe.setText((new StringBuilder()).append(Concatenar).append(num).toString());
    }

    public int Edad(Date fechaInicial)
    {
        Calendar calendarioAhora = Calendar.getInstance();
        calendarioAhora.add(10, -5);
        Date fechaActual = calendarioAhora.getTime();
        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaActual.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double aF1os = Math.floor(diferencia / 0x5265c00L / 365L);
        return (int)aF1os;
    }

    public boolean TextVacios(JPanel jPanel)
    {
        Component componentes[] = new Component[jPanel.getComponentCount()];
        componentes = jPanel.getComponents();
        boolean r = false;
        for(int i = 0; i < jPanel.getComponentCount(); i++)
        {
            if(!componentes[i].getClass().getName().equals("javax.swing.JTextField"))
                continue;
            JTextField caja = (JTextField)componentes[i];
            if(!caja.getText().equals(""))
                continue;
            caja.requestFocus();
            r = true;
            JOptionPane.showMessageDialog(null, "Existen Campos Vacios");
            break;
        }

        return r;
    }

    public boolean ComboVacios(JPanel jPanel)
    {
        Component componentes[] = new Component[jPanel.getComponentCount()];
        componentes = jPanel.getComponents();
        boolean r = false;
        for(int i = 0; i < jPanel.getComponentCount(); i++)
        {
            if(!componentes[i].getClass().getName().equals("javax.swing.JComboBox"))
                continue;
            JComboBox caja = (JComboBox)componentes[i];
            if(!caja.getSelectedItem().equals(""))
                continue;
            caja.requestFocus();
            r = true;
            JOptionPane.showMessageDialog(null, "Existen Campos Vacios");
            break;
        }

        return r;
    }

    public static void PasarGrilla(MouseEvent evt, JTable Actual, JButton Guardar, JButton Modificar, JButton Eliminar, int Activo)
    {
        if(Actual.getSelectedColumn() != -1 && Activo == 1)
        {
            Eliminar.setEnabled(true);
            Guardar.setEnabled(false);
            Modificar.setEnabled(false);
        }
    }

    public static SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

}
