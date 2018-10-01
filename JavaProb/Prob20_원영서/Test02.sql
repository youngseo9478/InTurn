--1. 자신의 매니저보다 채용일(hire_date)이 빠른 사원의 사번(employee_id), 성(last_name)과 채용일(hire_date)을 조회하라.
select e1.employee_id 사번, e1.last_name 성, e1.hire_date 채용일 
from EMPLOYEES e1, EMPLOYEES e2
where e1.hire_date>e2.hire_date
	and e1.manager_id = e2.employee_id;

--2. 각 사원(employee)에 대해서 사번(employee_id), 이름(first_name), 부서명(department_name), 
--   매니저(manager)의 이름(first_name)을 조회하시오.
select e1.employee_id 사번, e1.first_name 이름, d.department_name 부서명, e2.first_name 매니저 
from EMPLOYEES e1, EMPLOYEES e2, DEPARTMENTS d
where e1.manager_id=e2.employee_id
		and e1.department_id=d.department_id;
		
		
--3. 각 업무(job_title)가 어느 부서(department_name)에서 수행되는지 조회하는 SQL 쿼리문을 작성하세요.
--   (단, 수행하지 않는 업무는 표시하지 않고 중복되는 정보는 하나만 표시합니다.)
select distinct job.job_title, d.department_name
from DEPARTMENTS d, EMPLOYEES e, JOBS job
where e.job_id=job.job_id and e.department_id = d.department_id
order by 1;

--4. 특정 사원의 사원 번호(employee_id)가 다른 사원의 관리자 번호(manager_id)에 있는 사원인 경우, 이 사원을 관리자라고 가정합니다. 
--이름(FIRST_NAME)에 "v"(소문자)가 들어간 사원들에 대해 사원 번호(EMPLOYEE_ID), 이름(FIRST_NAME), 관리자 이름(관리자의 FIRST_NAME)을 
--조회하고 관리자가 없는 경우에는 관리자 이름에 "NOT EXIST"라고 출력하도록 SQL 쿼리를 작성하세요.
select e1.employee_id "사원 번호", e1.first_name 이름, nvl(e2.first_name,'NOT EXIST') "관리자 이름" 
from EMPLOYEES e1, EMPLOYEES e2
where e1.first_name like '%v%'
	  and e1.manager_id = e2.employee_id(+)
order by 1;

--5. 사원 이름과 해당 사원의 상사 이름을 출력하시오. 이 때 상사가 없는 경우도 출력되도록 하시오.
--출력: 사원이름 | 상사이름
--(단, 이름의 형식은 first_name과 last_name을 공백으로 구분한 형태입니다.)
select e1.first_name||' '||e1.last_name, e2.first_name||' '||e2.last_name
from EMPLOYEES e1, EMPLOYEES e2
where e1.manager_id = e2.employee_id(+);








