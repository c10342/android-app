import { Router } from 'express';
import { login } from '../controllers/authController';

const router = Router();

// 登录接口
router.post('/login', login);

export default router;
