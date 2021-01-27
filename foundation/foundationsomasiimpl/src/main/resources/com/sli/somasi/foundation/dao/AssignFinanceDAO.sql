--listDebitur
select * from somasi_konsumen k
left join somasi_assignfinance af on af.konsumenid = k.konsumenid
where (af.sp = true or af.spt = true) and af.print = true

--listNoDebitur
select af.* from somasi_mappingareakapos sm 
left join somasi_agentpos sa on sm.cityid = sa.cityid 
left join somasi_assignfinance af on sa.idagentpos = af.idagentpos 
where sm.userid = {{userId}}

--getAssign
select * from somasi_assignfinance sa where idagentpos = {{idAgent}} and konsumenid = {{idkonsumen}}