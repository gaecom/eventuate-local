package io.eventuate.local.unified.cdc.pipeline.dblog.mysqlbinlog.configuration;

import io.eventuate.local.common.MySqlBinlogCondition;
import io.eventuate.local.unified.cdc.pipeline.common.BinlogEntryReaderProvider;
import io.eventuate.local.unified.cdc.pipeline.common.factory.CdcPipelineReaderFactory;
import io.eventuate.local.unified.cdc.pipeline.dblog.mysqlbinlog.factory.MySqlBinlogCdcPipelineReaderFactory;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySqlBinlogDefaultCdcPipelineReaderFactoryConfiguration {
  @Conditional(MySqlBinlogCondition.class)
  @Bean("defaultCdcPipelineReaderFactory")
  public CdcPipelineReaderFactory defaultMySqlBinlogCdcPipelineFactory(CuratorFramework curatorFramework,
                                                                       BinlogEntryReaderProvider binlogEntryReaderProvider) {

    return new MySqlBinlogCdcPipelineReaderFactory(curatorFramework, binlogEntryReaderProvider);
  }
}
