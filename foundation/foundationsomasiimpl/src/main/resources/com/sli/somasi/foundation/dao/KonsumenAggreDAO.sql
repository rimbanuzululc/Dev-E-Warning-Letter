/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  hp
 * Created: Jul 28, 2019
 */

--listKonsumen
select * from somasi_konsumen;

--getbyId
select * from somasi_konsumen where konsumenid = {{id}}

--searchFinance
select 
k.*,
ap.nama as agentname
from somasi_konsumen k
left join somasi_assignfinance a on k.konsumenid = a.konsumenid
left join somasi_agentpos ap on a.idagentpos = ap.idagentpos
[[addParam]]
order by k.upload_date asc
limit 10 offset [[start]]

--getByNa
select 
	k.*,
	(select description from somasi_status1 where idstatus1 = h.idstatus1) as statusagent
from somasi_konsumen k
left join somasi_historystatus h on k.konsumenid = h.konsumenid
where k.noaggrement = '[[no]]';

--listSomasi
select 
	k.namadebitur,
	k.alamatktp as alamat,
	k.notelp,
	k.noaggrement,
	k.type,
	k.nomorpolisi
from somasi_konsumen k 
left join somasi_assignfinance a on k.konsumenid = a.konsumenid
left join somasi_agentpos ap on a.idagentpos = ap.idagentpos
where ap.idagentpos = {{idAgent}} and (k.sendsomasi1date is null and  K.type = 'SOMASI1') 
or (k.sendsomasi2date is null and k.type = 'SOMASI2');

--getKonsumenByIdAgent
select 
	k.*
from somasi_konsumen k 
left join somasi_assignfinance a on k.konsumenid = a.konsumenid
left join somasi_agentpos ap on a.idagentpos = ap.idagentpos
where ap.idagentpos = {{idAgent}};

--history
select 
        distinct (select ("max"(af.assign_date)) from somasi_assignfinance af where af.konsumenid = k.konsumenid) as assignDate,
        k.*
from somasi_konsumen k
left join somasi_assignfinance af on k.konsumenid = af.konsumenid
left join somasi_agentpos ap on af.idagentpos = ap.idagentpos
where (k.sendsomasi1date is not null or k.sendsomasi2date is not null) and ap.idagentpos = {{idAgent}};


--listSomasiKA
select
	distinct (select ("max"(af.assign_date)) from somasi_assignfinance af where af.konsumenid = k.konsumenid) as assign_date,
	k.namadebitur,
	k.alamatktp as alamat,
	k.notelp,
	k.noaggrement,
	k.type,
	k.nomorpolisi
from somasi_konsumen k 
left join somasi_assignfinance af on k.konsumenid = af.konsumenid
left join somasi_agentpos ap on af.idagentpos = ap.idagentpos
left join somasi_mappingareakapos mka on ap.idmappingarea = mka.idmappingarea 
where (k.sendsomasi1date is not null or k.sendsomasi2date is not null) 
and (mka.idmappingarea = ap.idmappingarea) and k.statusbyphone is null
and mka.idagentpos = {{idAgent}};


--historyKA
select
	distinct (select ("max"(af.assign_date)) from somasi_assignfinance af where af.konsumenid = k.konsumenid) as assignDate,
	k.*
from somasi_konsumen k 
left join somasi_assignfinance af on k.konsumenid = af.konsumenid
left join somasi_agentpos ap on af.idagentpos = ap.idagentpos
left join somasi_mappingareakapos mka on ap.idmappingarea = mka.idmappingarea 
where (k.sendsomasi1date is not null or k.sendsomasi2date is not null) 
and (mka.idmappingarea = ap.idmappingarea) and  k.statusbyphone is not null
and mka.idagentpos = {{idAgent}};