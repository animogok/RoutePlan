package GUI;

import java.awt.EventQueue;

class Main{

    public static void main(String[] args) {

        /*
         * 
         * Test 1: Login and register in terms of connection between both classes
         */

		EventQueue.invokeLater(() -> {
                    try {
                        Login_ex window_login = new Login_ex();
                        window_login.frame.setVisible(true);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            });

	}
}