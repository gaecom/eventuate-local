package io.eventuate.local.unified.cdc.pipeline.dblog.postgreswal.configuration;

import io.eventuate.local.unified.cdc.pipeline.common.properties.CdcPipelineProperties;
import io.eventuate.local.unified.cdc.pipeline.common.properties.CdcPipelineReaderProperties;
import io.eventuate.local.unified.cdc.pipeline.dblog.common.configuration.CommonDbLogCdcDefaultPipelinePropertiesConfiguration;
import io.eventuate.local.unified.cdc.pipeline.dblog.postgreswal.properties.PostgresWalCdcPipelineProperties;
import io.eventuate.local.unified.cdc.pipeline.dblog.postgreswal.properties.PostgresWalCdcPipelineReaderProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class PostgresWalDefaultCdcPipelinePropertiesConfiguration extends CommonDbLogCdcDefaultPipelinePropertiesConfiguration {

  @Profile("PostgresWal")
  @Bean
  public CdcPipelineProperties defaultPostgresWalPipelineProperties() {
    PostgresWalCdcPipelineProperties postgresWalCdcPipelineProperties = createPostgresWalCdcPipelineProperties();

    initCommonDbLogCdcPipelineProperties(postgresWalCdcPipelineProperties);
    initCdcPipelineProperties(postgresWalCdcPipelineProperties);

    return postgresWalCdcPipelineProperties;
  }

  @Profile("PostgresWal")
  @Bean
  public CdcPipelineReaderProperties defaultPostgresWalPipelineReaderProperties() {
    PostgresWalCdcPipelineReaderProperties postgresWalCdcPipelineReaderProperties = createPostgresWalCdcPipelineReaderProperties();

    initCommonDbLogCdcPipelineReaderProperties(postgresWalCdcPipelineReaderProperties);
    initCdcPipelineReaderProperties(postgresWalCdcPipelineReaderProperties);

    return postgresWalCdcPipelineReaderProperties;
  }

  private PostgresWalCdcPipelineProperties createPostgresWalCdcPipelineProperties() {
    PostgresWalCdcPipelineProperties postgresWalCdcPipelineProperties = new PostgresWalCdcPipelineProperties();

    postgresWalCdcPipelineProperties.setPostgresReplicationStatusIntervalInMilliseconds(eventuateConfigurationProperties.getPostgresReplicationStatusIntervalInMilliseconds());
    postgresWalCdcPipelineProperties.setPostgresReplicationSlotName(eventuateConfigurationProperties.getPostgresReplicationSlotName());
    postgresWalCdcPipelineProperties.setPostgresWalIntervalInMilliseconds(eventuateConfigurationProperties.getPostgresWalIntervalInMilliseconds());

    return postgresWalCdcPipelineProperties;
  }

  private PostgresWalCdcPipelineReaderProperties createPostgresWalCdcPipelineReaderProperties() {
    PostgresWalCdcPipelineReaderProperties postgresWalCdcPipelineReaderProperties = new PostgresWalCdcPipelineReaderProperties();

    postgresWalCdcPipelineReaderProperties.setPostgresReplicationStatusIntervalInMilliseconds(eventuateConfigurationProperties.getPostgresReplicationStatusIntervalInMilliseconds());
    postgresWalCdcPipelineReaderProperties.setPostgresReplicationSlotName(eventuateConfigurationProperties.getPostgresReplicationSlotName());
    postgresWalCdcPipelineReaderProperties.setPostgresWalIntervalInMilliseconds(eventuateConfigurationProperties.getPostgresWalIntervalInMilliseconds());

    return postgresWalCdcPipelineReaderProperties;
  }
}
