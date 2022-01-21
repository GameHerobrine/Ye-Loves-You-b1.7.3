package net.minecraft.src;

import net.minecraft.src.MEDMEX.Modules.Client.AutoReconnect;
import net.minecraft.src.MEDMEX.UI.MainMenu;
import net.minecraft.src.MEDMEX.Utils.Timer;

public class GuiConnectFailed extends GuiScreen {
    private String errorMessage;
    private String errorDetail;
    public static String lastip;
    public static int lastport;

    public GuiConnectFailed(String var1, String var2, Object... var3) {
        StringTranslate var4 = StringTranslate.getInstance();
        this.errorMessage = var4.translateKey(var1);
        if (var3 != null) {
            this.errorDetail = var4.translateKeyFormat(var2, var3);
        } else {
            this.errorDetail = var4.translateKey(var2);
        }

    }
    
    Timer timer = new Timer();

    public void updateScreen() {
    	if(AutoReconnect.instance.isEnabled()) {
    		if(timer.hasTimeElapsed(5000, true)) {
            	mc.displayGuiScreen(new GuiConnecting(mc, lastip, lastport));
    		}
    	}
    }

    protected void keyTyped(char var1, int var2) {
    }

    public void initGui() {
        StringTranslate var1 = StringTranslate.getInstance();
        this.controlList.clear();
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, var1.translateKey("gui.toMenu")));
    }

    protected void actionPerformed(GuiButton var1) {
        if (var1.id == 0) {
            this.mc.displayGuiScreen(new MainMenu());
        }

    }

    public void drawScreen(int var1, int var2, float var3) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.errorMessage, this.width / 2, this.height / 2 - 50, 16777215);
        this.drawCenteredString(this.fontRenderer, this.errorDetail, this.width / 2, this.height / 2 - 10, 16777215);
        this.drawCenteredString(this.fontRenderer, "Reconnecting in: "+timer.timeleft / 1000 +"s", this.width / 2, this.height / 2 - 100, 16777215);
        super.drawScreen(var1, var2, var3);
    }
}
