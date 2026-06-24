import crypto from 'crypto';
import { Request, Response } from 'express';
import { ApiResponse, HttpError } from '../types';

interface LoginBody {
  username: string;
  password: string;
}

interface LoginResult {
  token: string;
  username: string;
}

// 模拟账号数据（实际项目中应从数据库查询并对密码做哈希校验）
const mockUser = {
  username: 'admin',
  password: '123456',
};

// 生成随机 token
const generateToken = (): string => {
  return crypto.randomBytes(32).toString('hex');
};

// 登录接口
export const login = (req: Request<unknown, unknown, LoginBody>, res: Response): void => {
  const { username, password } = req.body ?? {};

  // 参数校验
  if (!username || !password) {
    throw new HttpError(400, '账号和密码为必填项');
  }

  // 账号密码校验
  if (username !== mockUser.username || password !== mockUser.password) {
    throw new HttpError(401, '账号或密码错误');
  }

  // 校验成功，生成随机 token
  const token = generateToken();

  const response: ApiResponse<LoginResult> = {
    code: 200,
    message: '登录成功',
    data: { token, username },
  };
  res.status(200).json(response);
};
