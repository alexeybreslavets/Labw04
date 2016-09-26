import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class okno extends JFrame {
    private int count = 0;
    public static int count2 = 1;
    public static int count3 = 0;
    public static String name;

    private JTextField fio = new JTextField(20);
    private JLabel metka = new JLabel("Ваше имя?");
    private JLabel metkaDva = new JLabel("");
    private JLabel metkaTri = new JLabel("");

    class PushingListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Object button = e.getSource();
            if(button instanceof JButton){
                count++;
                ((JButton)button).setText("Нажато " + count + " раз");
                metkaDva.setText("Спасибо, " + fio.getText() + "!");
                name = fio.getText();
                setTitle("Работа №4. " + name);
                System.out.println(name);
            }
        }
    }

    class PushingListener2 implements ActionListener {
        public void actionPerformed(ActionEvent b){
            Object button2 = b.getSource();
            if(button2 instanceof JButton){
                count2 = count2 * (-1);
                count3++;
                metkaTri.setText("Размер изменён " + count3 + " раз");
                if (count2 == -1) {
                    ((JButton) button2).setText("Вернуть начальный размер окна?");
                    setSize(500, 500);
                }else{
                    ((JButton) button2).setText("Изменить размер окна?");
                    setSize(450, 200);
                }
                System.out.println(count2);
            }
        }
    }

    public okno()
    {
        super();
        SozdatxOkno();
    }

    private void SozdatxOkno(){

        JButton button = new JButton(" Нажми меня! ");
        button.setBounds(5,60,135,40);
        button.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        JButton button2 = new JButton("Изменить размер окна?");
        button2.setBounds(145,60,250,40);
        button2.setBackground(Color.yellow);
        button2.setForeground(new Color(170, 00, 00));
        button2.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        Color color = button2.getBackground();
        button.setBackground(color);
        Color color2 = button2.getForeground();
        button.setForeground(color2);

        PushingListener s1 = new PushingListener();
        button.addActionListener(s1);
        PushingListener2 s2 = new PushingListener2();
        button2.addActionListener(s2);

        metka.setBounds(15, 15, 95, 30);
        metkaDva.setBounds(15, 115, 200, 30);
        metkaDva.setForeground(new Color(120, 0, 120));
        Font font = new Font("Century", Font.BOLD, 18);
        metkaDva.setFont(font);

        metkaTri.setBounds(230, 115, 200, 30);
        metkaTri.setForeground(new Color(0, 120, 0));
        Font font2 = new Font("Arial", Font.ITALIC, 18);
        metkaTri.setFont(font2);

        fio.setBounds(120, 15, 100, 30);
        fio.setText("Вы");
        fio.setBackground(new Color(210, 210, 210));
        fio.setForeground(Color.BLUE);

        getContentPane().setLayout(null);
        getContentPane().add(button);
        getContentPane().add(button2);
        getContentPane().add(metka);
        getContentPane().add(metkaDva);
        getContentPane().add(metkaTri);
        getContentPane().add(fio);

        setLocationRelativeTo(null);
    }
}