1. 각 업무(job) 별로 연봉(salary)의 총합을 구하고자 한다. 
   연봉 총합이 가장 높은 업무부터 업무명(job_title)과 연봉 총합을 조회하시오.

select job_title 업무명, sum(salary) "연봉 총합"
from employees e, jobs j
where j.job_id = e.job_id
group by e.job_id, j.job_title
order by "연봉 총합" desc;

2. 월 별 입사자 수를 조회하는 SQL 쿼리문을 작성하세요. 월 순으로 정렬하세요. 
   (출력: 월 | 입사자수)

select to_char(hire_date,'mm') "월", count(employee_id) 
from employees
group by to_char(hire_date,'mm')
order by 월;

3. 도시명(city)이 'Southlake'인 지역에 근무하는 직원 중에 연봉을 가장 많은 받는 
   직원의 사번(employee_id), 이름(first_name), 연봉(salary)을 출력하시오.

   select employee_id, first_name, salary
   from(select * from employees e, departments d, locations l
   		where e.department_id = d.department_id
   		and d.location_id = l.location_id
   		and l.city = 'Southlake')
   where rownum = 1;
   


4. 부서 이름(department_name) 별 직원들의 평균연봉(salary) 을 조회하시오.
단, ‘30번’ 부서의 직원 평균 연봉보다 평균 연봉이 이하인 부서 정보만 출력되어야 합니다. 

select d.department_name, avg(e.salary)
from departments d, employees e
where d.department_id = e.department_id
having avg(e.salary)<=(select avg(e2.salary)
					from departments d2, employees e2
					where d2.department_id = 30
					and d2.department_id = e2.department_id)
group by d.department_name;

