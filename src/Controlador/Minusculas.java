

package Controlador;

import javax.swing.text.*;

public class Minusculas extends PlainDocument
{

    public Minusculas()
    {
    }

    public void insertString(int offs, String str, AttributeSet a)
        throws BadLocationException
    {
        if(str == null)
            return;
        char lower[] = str.toCharArray();
        for(int i = 0; i < lower.length; i++)
            lower[i] = Character.toLowerCase(lower[i]);

        super.insertString(offs, new String(lower), a);
    }
}
