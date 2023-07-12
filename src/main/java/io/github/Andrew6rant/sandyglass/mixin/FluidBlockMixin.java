package io.github.andrew6rant.sandyglass.mixin;

import com.google.common.collect.UnmodifiableIterator;
import io.github.andrew6rant.sandyglass.SandyGlass;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(FluidBlock.class)
public abstract class FluidBlockMixin {
    @Shadow protected abstract void playExtinguishSound(WorldAccess world, BlockPos pos);

    @Inject(method = "receiveNeighborFluids(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)Z",
    at = @At(value = "INVOKE", target = "Lnet/minecraft/fluid/FluidState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z", shift = At.Shift.BEFORE), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void sandyglass$receiveNeighborFluids(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir, boolean bl, UnmodifiableIterator var5, Direction direction) {
        BlockPos directionPos = pos.offset(direction);
        if (world.getBlockState(directionPos).isOf(Blocks.SAND)) {
            world.setBlockState(directionPos, SandyGlass.SANDY_GLASS.getDefaultState());
            this.playExtinguishSound(world, directionPos);
            cir.setReturnValue(false);
        }
        else if (world.getBlockState(directionPos).isOf(Blocks.RED_SAND)) {
            world.setBlockState(directionPos, SandyGlass.RED_SANDY_GLASS.getDefaultState());
            this.playExtinguishSound(world, directionPos);
            cir.setReturnValue(false);
        }
    }
}
