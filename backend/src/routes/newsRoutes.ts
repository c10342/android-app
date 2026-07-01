import { Router } from 'express';
import { getNewsList } from '../controllers/newsController';

const router = Router();

// 新闻播放列表分页查询
router.get('/list', getNewsList);

export default router;
