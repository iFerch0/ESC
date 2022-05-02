

package Controlador;

import javax.swing.text.*;

public class Mayusculas extends PlainDocument
{

    public Mayusculas()
    {
    }

    public void insertString(int offs, String str, AttributeSet a)
        throws BadLocationException
    {
        if(str == null)
            return;
        char upper[] = str.toCharArray();
        for(int i = 0; i < upper.length; i++)
            upper[i] = Character.toUpperCase(upper[i]);

        super.insertString(offs, new String(upper), a);
    }
}
