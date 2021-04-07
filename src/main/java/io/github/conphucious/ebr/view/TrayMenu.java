package io.github.conphucious.ebr.view;

import javax.swing.*;
import java.awt.*;

public class TrayMenu {
    private TrayIcon trayIcon;
    private PopupMenu menu;
    private MenuItem miConnect, miSetConfig, miManageItems, miExit;

    public TrayMenu() {
        trayIcon = new TrayIcon(new ImageIcon("./icon.png").getImage());
        menu = new PopupMenu();

        miConnect = new MenuItem("Connect Device");
        miSetConfig = new MenuItem("Configure Device");
        miManageItems = new MenuItem("Manage Tracked Items");
        miExit = new MenuItem("Exit");

        menu.add(miConnect);
        menu.add(miSetConfig);
        menu.add(miManageItems);
        menu.add(miExit);

        trayIcon.setImageAutoSize(true);
        trayIcon.setPopupMenu(menu);
        try {
            SystemTray.getSystemTray().add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
