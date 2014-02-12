package mods.roborave.edm;
import java.util.Arrays;

import mods.roborave.edm.helper.LocalizationHandler;
import mods.roborave.edm.helper.LogHandler;
import mods.roborave.edm.init.Blocks;
import mods.roborave.edm.init.Items;
import mods.roborave.edm.lib.Strings;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Strings.MODID, name = Strings.name, version = Strings.version,canBeDeactivated=true)

public class EDM {
	
	public static LogHandler log;
	
	@Instance(Strings.MODID)
	public EDM Instance;
	
	/**
	 * Loads before
	 * @param PreEvent
	 */
	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent)
	{
		ModMetadata meta = PreEvent.getModMetadata();
		meta.autogenerated = false;
		meta.credits = "(C) Roborave, 2013-2014";
		meta.authorList = Arrays.asList("Roborave");
		meta.name = Strings.name;
		meta.version = Strings.version;
		meta.description = "";
		
		LocalizationHandler.init();
		Blocks.init();
		Items.init();
	}
	
	/**
	 * Loads during
	 * @param event
	 */
	@EventHandler
	public static void load(FMLInitializationEvent event)
	{
		
	}
	
	/**
	 * Loads after
	 * @param PostEvent
	 */
	@EventHandler
	public static void PostLoad(FMLPostInitializationEvent PostEvent)
	{
		
	}
	
}
