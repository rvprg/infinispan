package org.infinispan.configuration.global;

public class ShutdownConfigurationBuilder extends AbstractGlobalConfigurationBuilder<ShutdownConfiguration> {
   
   private ShutdownHookBehavior shutdownHookBehavior = ShutdownHookBehavior.DEFAULT;
   
   ShutdownConfigurationBuilder(GlobalConfigurationBuilder globalConfig) {
      super(globalConfig);
   }

   public ShutdownConfigurationBuilder hookBehavior(ShutdownHookBehavior hookBehavior) {
      this.shutdownHookBehavior = hookBehavior;
      return this;
   }
   
   @Override
   void validate() {
      // No-op, no validation required
   }
   
   @Override
   ShutdownConfiguration create() {
      return new ShutdownConfiguration(shutdownHookBehavior);
   }
   
   @Override
   ShutdownConfigurationBuilder read(ShutdownConfiguration template) {
      this.shutdownHookBehavior = template.hookBehavior();
      
      return this;
   }

   @Override
   public String toString() {
      return "ShutdownConfigurationBuilder{" +
            "shutdownHookBehavior=" + shutdownHookBehavior +
            '}';
   }

}