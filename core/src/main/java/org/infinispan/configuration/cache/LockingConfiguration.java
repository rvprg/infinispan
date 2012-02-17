package org.infinispan.configuration.cache;

import org.infinispan.util.concurrent.IsolationLevel;

/**
 * Defines the local, in-VM locking and concurrency characteristics of the cache.
 * 
 * @author pmuir
 * 
 */
public class LockingConfiguration {

   private final int concurrencyLevel;
   private final IsolationLevel isolationLevel;
   private long lockAcquisitionTimeout;
   private final boolean useLockStriping;
   private final boolean writeSkewCheck;

   LockingConfiguration(int concurrencyLevel, IsolationLevel isolationLevel, long lockAcquisitionTimeout,
         boolean useLockStriping, boolean writeSkewCheck) {
      this.concurrencyLevel = concurrencyLevel;
      this.isolationLevel = isolationLevel;
      this.lockAcquisitionTimeout = lockAcquisitionTimeout;
      this.useLockStriping = useLockStriping;
      this.writeSkewCheck = writeSkewCheck;
   }

   /**
    * Concurrency level for lock containers. Adjust this value according to the number of concurrent
    * threads interacting with Infinispan. Similar to the concurrencyLevel tuning parameter seen in
    * the JDK's ConcurrentHashMap.
    */
   public int concurrencyLevel() {
      return concurrencyLevel;
   }

   /**
    * Cache isolation level. Infinispan only supports READ_COMMITTED or REPEATABLE_READ isolation
    * levels. See <a href=
    * 'http://en.wikipedia.org/wiki/Isolation_level'>http://en.wikipedia.org/wiki/Isolation_level</a
    * > for a discussion on isolation levels.
    */
   public IsolationLevel isolationLevel() {
      return isolationLevel;
   }

   /**
    * Maximum time to attempt a particular lock acquisition
    */
   public long lockAcquisitionTimeout() {
      return lockAcquisitionTimeout;
   }

   public LockingConfiguration lockAcquisitionTimeout(long lockAcquisitionTimeout) {
      this.lockAcquisitionTimeout = lockAcquisitionTimeout;
      return this;
   }

   /**
    * If true, a pool of shared locks is maintained for all entries that need to be locked.
    * Otherwise, a lock is created per entry in the cache. Lock striping helps control memory
    * footprint but may reduce concurrency in the system.
    */
   public boolean useLockStriping() {
      return useLockStriping;
   }

   /**
    * This setting is only applicable in the case of REPEATABLE_READ. When write skew check is set
    * to false, if the writer at commit time discovers that the working entry and the underlying
    * entry have different versions, the working entry will overwrite the underlying entry. If true,
    * such version conflict - known as a write-skew - will throw an Exception.
    */
   public boolean writeSkewCheck() {
      return writeSkewCheck;
   }

   @Override
   public String toString() {
      return "LockingConfiguration{" +
            "concurrencyLevel=" + concurrencyLevel +
            ", isolationLevel=" + isolationLevel +
            ", lockAcquisitionTimeout=" + lockAcquisitionTimeout +
            ", useLockStriping=" + useLockStriping +
            ", writeSkewCheck=" + writeSkewCheck +
            '}';
   }

}
