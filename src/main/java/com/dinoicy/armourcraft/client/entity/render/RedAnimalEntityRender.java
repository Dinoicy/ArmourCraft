package com.dinoicy.armourcraft.client.entity.render;

import com.dinoicy.armourcraft.ArmourCraft;
import com.dinoicy.armourcraft.client.entity.model.RedAnimalEntityModel;
import com.dinoicy.armourcraft.entities.RedAnimalEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RedAnimalEntityRender extends MobRenderer<RedAnimalEntity, RedAnimalEntityModel<RedAnimalEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ArmourCraft.MOD_ID,
            "textures/entity/red_animal_entity.png");

    public RedAnimalEntityRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RedAnimalEntityModel<RedAnimalEntity>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(RedAnimalEntity entity) {
        return TEXTURE;
    }
}
