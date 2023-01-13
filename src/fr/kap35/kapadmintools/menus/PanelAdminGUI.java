package fr.kap35.kapadmintools.menus;

import fr.kap35.kapadmintools.KapAdminTools;
import fr.kap35.kapeasymenu.Items.GuiItem;
import fr.kap35.kapeasymenu.Menu.GuiMenu;

public class PanelAdminGUI extends GuiMenu {

    public PanelAdminGUI(KapAdminTools plugin) {
        super(plugin, 9, "Panel Admin");
    }

    @Override
    protected void initGUI() {
        super.initGUI();
        System.out.println("Init GUI Pnale Admin");
        addItem(new GuiItem(getPlugin(), ((KapAdminTools)getPlugin()).getItems().nextPage(), (player, plugin) -> {
            GuiMenu menu = ((KapAdminTools) getPlugin()).getGuiManager().getMenu("Panel Admin 2");
            if (menu != null) {
                menu.openGUI(player);
            } else {
                player.sendMessage("Menu doesn't develop now !");
            }
        }, 0, true));
    }

    @Override
    protected void updateGUI() {
    }
}
