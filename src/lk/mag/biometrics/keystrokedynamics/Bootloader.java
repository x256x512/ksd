package lk.mag.biometrics.keystrokedynamics;

import lk.mag.biometrics.keystrokedynamics.file.FileIO;

public class Bootloader {

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {

        }

        if (FileIO.firstTime()) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new RegisterForm().setVisible(true);
                }
            });
        } else {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new LoginForm().setVisible(true);
                }
            });
        }

    }
}
