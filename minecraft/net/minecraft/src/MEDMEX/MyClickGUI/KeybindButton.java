package net.minecraft.src.MEDMEX.MyClickGUI;

import net.minecraft.src.GuiScreen;
import net.minecraft.src.MEDMEX.Modules.Module;

public class KeybindButton extends GuiScreen{
	int startX;
	int startZ;
	int endX;
	int endZ;
	Module m;

	public KeybindButton(int startX, int startZ, int endX, int endZ, Module m) {
		this.startX = startX;
		this.startZ = startZ;
		this.endX = endX;
		this.endZ = endZ;
		this.m = m;
	}
}
