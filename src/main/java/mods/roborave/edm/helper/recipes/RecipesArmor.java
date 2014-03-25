package mods.roborave.edm.helper.recipes;

import mods.roborave.edm.init.Armor;
import mods.roborave.edm.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesArmor
{
    private String[][] recipePatterns = new String[][] {{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    private Object[][] recipeItems;
    public RecipesArmor()
    {
        this.recipeItems = new Object[][] 
        {
        		{
        			Items.BD,
        			Items.BLD,
        			Items.GD,
        			Items.GRD,
        			Items.OD,
        			Items.PD,
        			Items.PUD
        		}, 
        		{
        			Armor.BDH, 
        			Armor.BLDH, 
        			Armor.GDH, 
        			Armor.GRDH,
        			Armor.ODH,
        			Armor.PDH,
        			Armor.PUDH
        		}, 
        		{
        			Armor.BDC, 
        			Armor.BLDC,
        			Armor.GDC,
        			Armor.GRDC,
        			Armor.ODC,
        			Armor.PDC,
        			Armor.PUDC
            	}, 
            	{
            		Armor.BDP, 
        			Armor.BLDP,
        			Armor.GDP,
        			Armor.GRDP,
        			Armor.ODP,
        			Armor.PDP, 
        			Armor.PUDP
            	}, 
            	{
            		Armor.BDB, 
        			Armor.BLDB,
        			Armor.GDB,
        			Armor.GRDB,
        			Armor.ODB,
        			Armor.PDB,
        			Armor.PUDB
            	}
          };
    }

    /**
     * Adds the armor recipes to the CraftingManager.
     */
    public void addRecipes()
    {
        for (int i = 0; i < this.recipeItems[0].length; ++i)
        {
            Object object = this.recipeItems[0][i];

            for (int j = 0; j < this.recipeItems.length - 1; ++j)
            {
                Item item = (Item)this.recipeItems[j + 1][i];
                GameRegistry.addRecipe(new ItemStack(item), new Object[] {this.recipePatterns[j], 'X', object});
            }
        }
    }
}