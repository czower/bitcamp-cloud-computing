// 주제: DAO 모듈 만들기

var pool;

exports.setConnectionPool = (connectionPool) => {
    pool = connectionPool;
};

exports.list = (pageNo = 1, pageSize = 3, handler) => {
    var startIndex = (pageNo - 1) * pageSize;
    
    pool.query('select bno, titl, cont, cdt from pms2_board limit ?, ?',
            [startIndex, pageSize],
            function(err, results) {
        handler(err, results);
    });
};

exports.add = (data, handler) => {
    pool.query(
        'insert into pms2_board(bno,titl,cont,cdt)\
        values(?, ?, ?, ?)',
        [data.bno, data.titl, data.cont, data.cdt],
        function(err, result) {
            handler(err, result);
    });
};

exports.update = (data, handler) => {
    pool.query(
        'update pms2_board set\
         titl=?,\
         cont=?,\
         cdt=?\
         where bno=?',
        [data.titl,
         data.cont,
         data.cdt,
         data.bno],
        function(err, result) {
            handler(err, result);
    });
};

exports.remove = (data, handler) => {
    pool.query(
        'delete from pms2_board where bno=?',
        [data.bno],
        function(err, result) {
            handler(err, result);
    });
};

//http://localhost:8000/board/list?pageNo=1&pageSize=50
//http://localhost:8000/board/add?bno=10&titl=제목&cont=내용&cdt=2018-08-20
//http://localhost:8000/board/update?bno=10&titl=okok&cont=내용&cdt=2018-12-12
//http://localhost:8000/board/delete?bno=10




