package xyz.ipiepiepie.migration.mixin;

import com.b100.utils.StringUtils;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.util.helper.UUIDHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = UUIDHelper.class, remap = false)
public class UUIDMixin {

	@Redirect(method = "getUUIDFromName", at = @At(value = "INVOKE", target = "Lcom/b100/utils/StringUtils;getWebsiteContentAsString(Ljava/lang/String;)Ljava/lang/String;"))
	private static String getUUIDFromNameMixin(String e, @Local(argsOnly = true) String username) {

		return StringUtils.getWebsiteContentAsString("https://api.minecraftservices.com/users/profiles/minecraft/" + username);
	}



}
