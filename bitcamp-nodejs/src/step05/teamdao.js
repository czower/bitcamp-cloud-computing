// 주제: DAO 모듈 만들기

var pool;

exports.setConnectionPool = (connectionPool) => {
    pool = connectionPool;
};

exports.list = (pageNo = 1, pageSize = 3, handler) => {
    var startIndex = (pageNo - 1) * pageSize;
    
    pool.query('select name, dscrt, max_qty, sdt, edt from pms2_team limit ?, ?',
            [startIndex, pageSize],
            function(err, results) {
        handler(err, results);
    });
};

exports.add = (data, handler) => {
    pool.query(
        'insert into pms2_team(name,dscrt,max_qty,sdt,edt)\
        values(?, ?, ?, ?, ?)',
        [data.name, data.dscrt, data.max_qty, data.sdt, data.edt],
        function(err, result) {
            handler(err, result);
    });
};

exports.update = (data, handler) => {
    pool.query(
        'update pms2_team set\
         dscrt=?,\
         max_qty=?,\
         sdt=?,\
         edt=?\
         where name=?',
        [data.dscrt,
         data.max_qty,
         data.sdt,
         data.edt,
         data.name],
        function(err, result) {
            handler(err, result);
    });
};

exports.remove = (data, handler) => {
    pool.query(
        'delete from pms2_team where name=?',
        [data.name],
        function(err, result) {
            handler(err, result);
    });
};

//http://localhost:8000/team/list?pageNo=1&pageSize=50
//http://localhost:8000/team/add?name=team03&dscrt=team03&max_qty=33&sdt=2018-08-20&edt=2020-09-07
//http://localhost:8000/team/update?name=team03&dscrt=okok&max_qty=1111&sdt=2018-12-12&edt=2019-03-01
//http://localhost:8000/team/delete?name=team03
