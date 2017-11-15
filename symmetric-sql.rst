::

   insert into SYM_NODE_GROUP
        (node_group_id, description)
        values ('source', 'A source data node');

   insert into SYM_NODE_GROUP
        (node_group_id, description)
        values ('datalake', 'A data lake node');


   insert into SYM_NODE_GROUP_LINK
         (source_node_group_id, target_node_group_id, 
         data_event_action) values ('source', 
         'datalake', 'R');


   insert into SYM_ROUTER (router_id,
        source_node_group_id, target_node_group_id, router_type,
        create_time, last_update_time) values ('source2datalake',
        'source', 'datalake', 'xmlfilerouter', current_timestamp, 
        current_timestamp);


   insert into SYM_CHANNEL (channel_id, processing_order, max_batch_size, max_batch_to_send,
         extract_period_millis, batch_algorithm, enabled, description)
         values ('table1', 10, 1000, 10, 0, 'default', 1, 'Sample table');


   insert into SYM_TRIGGER (trigger_id, source_table_name,
          channel_id, last_update_time, create_time)
          values ('table1', 'table1', 'table1', 
          current_timestamp, current_timestamp);

   insert into SYM_TRIGGER_ROUTER
         (trigger_id, router_id, initial_load_order, create_time,
         last_update_time) values ('table1', 'source2datalake', 1, 
         current_timestamp, current_timestamp);
