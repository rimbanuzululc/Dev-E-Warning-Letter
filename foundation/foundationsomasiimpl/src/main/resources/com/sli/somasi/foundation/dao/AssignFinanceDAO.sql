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

--reportSendDebitur
select * from somasi_konsumen k
left join somasi_assignfinance af on af.konsumenid = k.konsumenid
where af.idagentpos = {{id}}

--reportProductivity
select 
count(status) as berhasil,
count(status) as pending,
count(status) as failed
from somasi_assignfinance sa 
where idagentpos = {{id}} and status ilike '%[[status]]%' 
and submit_date > current_date - interval '[[time]]' [[param]]

--listPending
select * from somasi_assignfinance
where idagentpos = {{id}} and status ilike 'Pending'

--reportSendAllDebitur
select
af.*,
sk.*
from somasi_mappingareakapos sm 
left join somasi_agentpos sa on sm.cityid = sa.cityid 
left join somasi_assignfinance af on sa.idagentpos = af.idagentpos 
left join somasi_konsumen sk on af.konsumenid = sk.konsumenid 
where sm.userid = {{userId}}

--reportSendDebiturforAdmin
select
af.*,
sk.*
from somasi_mappingareadminpos sm 
left join somasi_agentpos sa on sm.districtid = sa.districtid 
left join somasi_assignfinance af on sa.idagentpos = af.idagentpos 
left join somasi_konsumen sk on af.konsumenid = sk.konsumenid 
where sm.userid =  {{userId}}