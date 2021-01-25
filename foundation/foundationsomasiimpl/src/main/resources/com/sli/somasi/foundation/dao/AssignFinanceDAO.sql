--listDebitur
select * from somasi_konsumen k
left join somasi_assignfinance af on af.konsumenid = k.konsumenid
where (af.sp = true or af.spt = true) and af.print = true
