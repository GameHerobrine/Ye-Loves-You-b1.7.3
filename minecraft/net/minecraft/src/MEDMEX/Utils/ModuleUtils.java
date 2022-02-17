package net.minecraft.src.MEDMEX.Utils;

import java.util.ArrayList;

import net.minecraft.src.MEDMEX.Client;
import net.minecraft.src.MEDMEX.Modules.Module.Category;
import net.minecraft.src.MEDMEX.Modules.Module;


public class ModuleUtils {
	
	public static Module getModuleByName(String name){
		for(Module m : Client.modules){
			if(m.name.equalsIgnoreCase(name)){
				return m;
			}
		}
		return null;
	}
	
	public static ArrayList<Module> getModulesByCategory(Category c){
		ArrayList<Module> mods = new ArrayList<>();
		for(Module m : Client.modules){
			if(m.category == c){
				mods.add(m);
			}
		}
		return mods;
	}

}
