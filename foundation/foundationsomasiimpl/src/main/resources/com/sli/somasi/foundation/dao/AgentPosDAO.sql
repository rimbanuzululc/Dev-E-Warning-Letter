--list
select
*
from somasi_agentpos

--getByZipcode
select 
* 
from somasi_agentpos where zipcode = {{zipcode}}

--getById
select
a.*
from somasi_agentpos a
where a.idagentpos = {{id}};

--listAssign
select
a.*
from somasi_assign a;

--getByUsername
select * from somasi_agentpos where username = {{username}}

--searchByCode
select
    *
from 
    somasi_setting
where
    code = {{code}}

--search
select * from somasi_agentpos where districtid = {{districtid}}
