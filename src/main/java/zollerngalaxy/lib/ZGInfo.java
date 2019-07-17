package zollerngalaxy.lib;

import java.util.Arrays;
import net.minecraftforge.fml.common.ModMetadata;

public class ZGInfo {
	
	public static final String MOD_ID = "zollerngalaxy";
	public static final String majorVersion = "1";
	public static final String minorVersion = "0";
	public static final String buildVersion = "0";
	public static final String modVersion = majorVersion + "." + minorVersion + "." + buildVersion;
	public static final String minecraftVersion = "1.12.2";
	public static final String officialName = "Zollern Galaxy";
	public static final String name = officialName;
	public static final String proxyLocation = "zollerngalaxy.proxy.";
	public static final String proxyClient = proxyLocation + "ClientProxy";
	public static final String proxyServer = proxyLocation + "CommonProxy";
	public static final String channel = ZGInfo.MOD_ID;
	public static final String FORGE_VERSION = "after:forge@[14.23.1.2555,);";
	public static final String DEPENDENCIES = "required-after:galacticraftcore@[4.0.1.-1,);"
			+ "required-after:galacticraftplanets@[4.0.1.-1,); required-after:micdoodlecore; "
			+ ZGInfo.FORGE_VERSION;
	
	public static void init(ModMetadata info) {
		info.autogenerated = false;
		info.modId = ZGInfo.MOD_ID;
		info.name = ZGInfo.name;
		info.version = ZGInfo.modVersion;
		info.description = "An adventurous space exploration add-on mod for Galacticraft.";
		info.credits = "All credits to Galacticraft Sources/API, Steve Kung, MJRLegends, and Sean Murray (No Man's Sky).";
		info.authorList = Arrays.asList("ZollernWolf");
	}
}